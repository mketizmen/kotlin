/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization

import org.jetbrains.kotlin.ObsoleteTestInfrastructure
import org.jetbrains.kotlin.checkers.AbstractDiagnosticsTest
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.cli.jvm.config.JvmClasspathRoot
import org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationComponentRegistrar

@OptIn(ObsoleteTestInfrastructure::class)
abstract class AbstractSerializationPluginDiagnosticTest : AbstractDiagnosticsTest() {
    private val runtimeLibraryPath = getSerializationLibraryRuntimeJar()

    override fun setupEnvironment(environment: KotlinCoreEnvironment) {
        SerializationComponentRegistrar.registerExtensions(environment.project)
        environment.updateClasspath(listOf(JvmClasspathRoot(runtimeLibraryPath!!)))
    }
}
