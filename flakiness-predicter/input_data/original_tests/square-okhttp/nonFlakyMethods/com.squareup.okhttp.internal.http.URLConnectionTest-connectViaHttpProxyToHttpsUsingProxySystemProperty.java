/** 
 * We weren't honoring all of the appropriate proxy system properties when connecting via HTTPS. http://b/3097518
 */
@Test public void connectViaHttpProxyToHttpsUsingProxySystemProperty() throws Exception {
  testConnectViaHttpProxyToHttps(ProxyConfig.PROXY_SYSTEM_PROPERTY);
}
