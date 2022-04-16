fun main(args: Array<String>) {
    val argsLine = args.toList().stream().reduce{ a, b -> a.plus(" $b") }.get()
    CommandLineParser().parse(argsLine)
}