package com.poc.poweradapter.item

import dagger.MapKey

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class RenderKey(val string: String)
