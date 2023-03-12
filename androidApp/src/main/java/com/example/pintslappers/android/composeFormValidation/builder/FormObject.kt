package com.example.pintslappers.android.composeFormValidation.builder
import kotlin.reflect.KProperty
import kotlin.reflect.KClass

abstract class FormObject<T> {
    protected open fun customSetup() {}
    protected infix fun <V> KProperty<V>.isMandatoryWhen(check: () -> Boolean) = run {
        if (check.invoke()) {
            println("do something")
        }
    }
}

annotation class Mandatory<T>(
    val rule: Array<KClass<out MandatoryRule<T>>> = []
)

interface MandatoryRule<T> {
    fun isMandatory(formState: T): Boolean
}

//object MandatoryForAdultRule: MandatoryRule<SignUpFormData> {
//    override fun isMandatory(formState : SignUpFormData): Boolean = when(formState.city) {
//        "US" -> false
//        else -> true
//    }
//}



class Program {
    fun run() {
    }
}