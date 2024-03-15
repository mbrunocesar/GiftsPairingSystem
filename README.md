# Gift Basket Challenge
please insert personal information

## Introduction

A packaging company is automating the packaging of gift baskets. 

The gifts can come in one of five shapes: `Square`, `Rectangle`, `Circle`, `Oval`, and `Triangle`. They also have various weights from `50` grams to `250` grams in increments of `50`g.

The packaging company receives a set of `7` random gifts from a gift company to arrange a basket. For example, the set may include: 

```
150g Square, 250g Oval, 50g Rectangle, 100g Triangle, 50g Circle, 50g Circle, 200g Rectangle
```

The packaging company must assemble the best possible basket of `5` gifts based on a set of rules. [See below](#optimal-basket-rules) for a list of rules that make optimal baskets.

Additionally, the packaging company uses different sets of rules for different seasons. [See below](#rule-sets-by-season) for a list of rule sets.

## Challenge Requirements

- Write a program that takes a list of 7 gifts as input (The program can be written in the language of your choice)
- The program output must indicate the the optimal set of 5 gifts to use for the basket (see below _Optimal Basket Rules_ section)
- The program must allow you to indicate the season (see below _Rules Sets by Season_ section)
- It is up to you to determine how data is input and output from this program (We will conform our tests to fit your input and output)
- Your work must be pushed to GitHub to this repository within **2 hours** from receiving this challenge.
    - Optional: you can make a separate branch for your code and create a PR instead of pushing directly to `main` 


## Evaluation

Your program will be evaluated on the following criteria ordered by importance:
1. Development best practices
2. Correctness
3. Completeness

----

## Optimal Basket Rules

A basket must always have 5 gifts. The following is a list of basket types ranked from most optimal to least optimal. When comparing two different baskets of the same type the one with the heaviest weight is considered better.

### 1: Perfect Variety: 
**Example:** `50g Square, 100g Circle, 150g Rectangle, 200g Triangle, 250g Oval` \
Five gifts all with different weights and shapes. 

### 2: Weight Variety:
**Example:** `50g Square, 100g Square, 150g Square, 200g Square, 250g Square` \
Five gifts with different weights of the same shape.

### 3: Shape Variety:
**Example:** `150g Square, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval` \
Five gifts with different shapes of all the same weight.

### 4: Perfect Pairing:
**Example:** `50g Square, 50g Square, 200g Circle, 200g Circle, 200g Circle` \
Three gifts of one shape and two of another. Each with consistent weights.

### 5: Shape Pairing:
**Example:** `150g Square, 50g Square, 50g Circle, 200g Circle, 200g Circle` \
Three gifts of one shape and two of another but with different weights.

### 6: Discount Basket:
**Example:** `150g Square, 50g Triangle, 50g Rectangle, 200g Circle, 200g Circle` \
A basket that doesn’t fall into the above categories.

----

## Rule Sets by Season

Rule sets determine which set of rules should be used to determine the optimal basket. If a particular basket rule is not included in a season, you can assume that it is **Discount Basket**. For example, if the input for the rule set was _Spring_ and a basket that would fall under **Perfect Variety** and a basket that would **Perfect Pairing** were passed in, the **Perfect Pairing** basket would be most optimal.

**Spring** \
4: Perfect Pairing \
5: Shape Pairing \
6: Discount Basket

**Summer** \
1: Perfect Variety \
2: Weight Variety \
3: Shape Variety \
4: Perfect Pairing \
5: Shape Pairing \
6: Discount Basket

**Autumn** \
1: Perfect Variety \
2: Weight Variety \
3: Shape Variety \
6: Discount Basket

**Winter** \
1: Perfect Variety \
4: Perfect Pairing \
6: Discount Basket

