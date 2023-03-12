package com.example.pintslappers.android.composeFormValidation.utils
import com.example.pintslappers.android.composeFormValidation.annotations.FieldValidation
import com.example.pintslappers.android.composeFormValidation.annotations.DynamicOptional
import kotlin.reflect.KProperty1
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import com.example.pintslappers.android.composeFormValidation.annotations.Optional
import com.example.pintslappers.android.composeFormValidation.validation.rules.OptionalStateRule

inline fun <T: Any, reified V:Annotation> KProperty1<T,V>.isAnnotatedWith(annotation: KClass<V>): Boolean {
    return this.hasAnnotation<V>()
}

fun <T: Any> KProperty1<T, *>.isFieldOptional() : Boolean = hasAnnotation<Optional>()

fun <T: Any> KProperty1<T, *>.validationAnnotations() = annotations.filter(Annotation::isFieldValidation)

fun Annotation.isFieldValidation() = annotationClass.hasAnnotation<FieldValidation>()

fun Annotation.getFieldValidationData() : FieldValidation =
    requireNotNull(annotationClass.findAnnotation<FieldValidation>()) {
        "${this.annotationClass.simpleName} must be annotated with @FieldValidation"
    }


fun <T: Any> DynamicOptional.getEvaluatorInstance() : OptionalStateRule<T> =
    requireNotNull(evaluator.objectInstance as? OptionalStateRule<T>) {
        "Unable to get instance of class ${evaluator.simpleName}"
    }