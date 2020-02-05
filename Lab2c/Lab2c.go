package main

import (
    "bufio"
    "fmt"
    "io"
    "os"
	"strconv"
	"math"
	"sync"
)

// ReadInts reads whitespace-separated ints from r. If there's an error, it
// returns the ints successfully read so far as well as the error value.
func ReadInts(r io.Reader) ([]int, error) {
    scanner := bufio.NewScanner(r)
    scanner.Split(bufio.ScanWords)
    var result []int
    for scanner.Scan() {
        x, err := strconv.Atoi(scanner.Text())
        if err != nil {
            return result, err
        }
        result = append(result, x)
    }
    return result, scanner.Err()
}

func ToSlice(c chan int) []int {
    s := make([]int, 0)
    for i := range c {
        s = append(s, i)
    }
    return s
}

func fight(respond chan<- int, wg *sync.WaitGroup, power []int, checked int) {
	defer wg.Done()

	contestant1 := power[checked]
	contestant2 := power[checked + 1]
	
	var winner int
	if contestant1 > contestant2 {
		winner = contestant1
	} else {
		winner = contestant2
	}
	respond <- winner
}

func main() {
    fd, err := os.Open("array.txt")
	power, err := ReadInts(fd)
	
	winners_amount := int(math.Ceil(float64(len(power)) / 2))

	for true {
		respond := make(chan int, winners_amount)
		var wg sync.WaitGroup
		var checked int
		checked = 0

		fmt.Println(power)

		wg.Add(winners_amount)

		for i := 0; i < winners_amount; i++ {
			go fight(respond, &wg, power, checked)
			checked = checked + 2
		}

		wg.Wait()
		close(respond)

		power = ToSlice(respond)

		if winners_amount == 1 {
			break
		}

		winners_amount = int(math.Ceil(float64(len(power)) / 2))
	}
	
	fmt.Println(power)
	
	fmt.Println(err)
}