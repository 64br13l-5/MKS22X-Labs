# Results.md
<details>
<summary style="font-size:21px"> Q&A </summary>
<br>
<pre>

Q.  Why did you choose the board size for your finalized table?

    A. I chose size 100 for my finalized table, as it is large enough to yield close to accurate results but not small enough to result in large processing times. 
Q. Why did you choose the number of repetitions size for your finalized table?

    A. I chose to use 100 repetitions, as it is enough to get a reasonably accurate average, but not enough to take a long time.
Q. What did your testing show about changing the board size?

    A. As board size increased, the density with the highest runtime neared 60%. 
Q. Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?

    A. As the board size increased, the maximum burn time increased as well. This was tested by using board sizes from as low as 20 to as high as 2000
Q. What density of trees yields the maximum burn time? 

    A. The density with the maximum burn time seems to converge at 60% as the board gets larger. 
</pre>
</details>

____
<details>
<summary style="font-size:21px"> Result Tables </summary>
<br>
<pre>



<br>

### Board Size 100, 100 Repetitions

| Density        | Runtime (average ticks per 100 trials)        |  
| ------------- |:-------------:| 
| 0% | 0.0 |
| 5% | 1.24 |
| 10% | 1.8 |
| 15% | 2.79 |
| 20% | 3.74 |
| 25% | 5.19 |
| 30% | 6.42 |
| 35% | 9.13 |
| 40% | 12.76 |
| 44% | 18.0 |
| 49% | 29.87 |
| 54% | 64.02 |
| 60% | 187.71 |
| 65% | 174.9 |
| 70% | 144.48 |
| 75% | 130.69 |
| 80% | 122.19 |
| 85% | 115.97 |
| 90% | 110.81 |
| 95% | 106.24 |
| 100% | 100.0 |

#### Max runtime = 187.71 ticks on average with a 60% density
<br>

### Board Size 2000, 100 Repetitions

| Density        | Runtime (average ticks per 100 trials)        |  
| ------------- |:-------------:|
| 57% | 750.77 |
| 59% | 2978.42 |
| 60% | 4867.65 |
| 61% | 3789.33 |
| 62% | 3407.99 |
| 63% | 3185.97 |
| 64% | 3043.69 |
| 65% | 2931.84 |

#### Max runtime = 4867.65 ticks on average with a 60% density

___
</details>
