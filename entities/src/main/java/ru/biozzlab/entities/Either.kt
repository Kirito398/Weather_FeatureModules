package ru.biozzlab.entities

sealed class Either<out L, out R> {
    data class Left<out L> (val l: L) : Either<L, Nothing>()
    data class Right<out R> (val r: R) : Either<Nothing, R>()

    fun <R> right(r: R) = Right(r)

    fun either(functionLeft: (L) -> Any, functionRight: (R) -> Any): Any =
        when(this) {
            is Left -> functionLeft(l)
            is Right -> functionRight(r)
        }
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when(this) {
        is Either.Left -> Either.Left(l)
        is Either.Right -> fn(r)
    }

fun <A, B, C> ((A) -> B).compose(f: (B) -> C): ((A) -> C) = {
    f(this(it))
}

fun <L, R> Either<L, R>.doNext(fn: (R) -> Unit): Either<L, R> {
    this.flatMap(fn.compose(::right))
    return this
}

fun <T, L, R> Either<L, R>.map(fn: (R) -> T): Either<L, T> {
    return this.flatMap(fn.compose(::right))
}