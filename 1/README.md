# Lazy solution
uses awk - pretty easy:
`awk '{ sum += $1 } END { print sum }' input.txt`

# Kotlin solution
