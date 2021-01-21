@Test public void shouldBuildDefaultConfigurationWhenConfigStreamIsNull(){
  Mockito.when(mockServletContext.getResourceAsStream(Mockito.anyString())).thenReturn(null);
  victim=new ServletContextPropertyWroConfigurationFactory(mockServletContext);
  Assert.assertNotNull(victim.create());
}
