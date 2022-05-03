package de.shyim.shopware6.inspection.store.composer

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.json.psi.JsonFile

abstract class ExtensionComposerInspection : LocalInspectionTool() {
    protected fun isExtensionComposerFile(holder: ProblemsHolder): Boolean {
        if (holder.file !is JsonFile) {
            return false
        }

        if (holder.file.name != "composer.json") {
            return false
        }

        return holder.file.text!!.contains("shopware-platform-plugin")
    }
}