@Test public void shouldLoadWroConfigurationFromServletContextAttribute() throws Exception {
  final WroFilter filter=new WroFilter();
  final WroConfiguration expectedConfig=new WroConfiguration();
  final ServletContextAttributeHelper helper=new ServletContextAttributeHelper(mockServletContext);
  Mockito.when(mockServletContext.getAttribute(helper.getAttributeName(Attribute.CONFIGURATION))).thenReturn(expectedConfig);
  filter.init(mockFilterConfig);
  Assert.assertSame(expectedConfig,filter.getConfiguration());
}
