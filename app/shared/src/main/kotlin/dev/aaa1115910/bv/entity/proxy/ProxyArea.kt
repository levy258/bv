package dev.aaa1115910.bv.entity.proxy

import dev.aaa1115910.bv.util.Prefs
import io.github.oshai.kotlinlogging.KotlinLogging

enum class ProxyArea {
    MainLand, HongKong, TaiWan;

    companion object {
        private val logger = KotlinLogging.logger { }
        fun checkProxyArea(title: String): ProxyArea {
            val enableProxy = Prefs.enableProxy
            val proxyArea = when {
                !enableProxy -> TaiWan
                title.contains(Regex("大陆|国产|国语|中文")) -> MainLand
                title.contains(Regex("僅.*港")) -> HongKong
                else -> TaiWan
            }
            if (enableProxy) logger.debug { "Check proxy area: $title->$proxyArea" }
            return proxyArea
        }
    }
}
