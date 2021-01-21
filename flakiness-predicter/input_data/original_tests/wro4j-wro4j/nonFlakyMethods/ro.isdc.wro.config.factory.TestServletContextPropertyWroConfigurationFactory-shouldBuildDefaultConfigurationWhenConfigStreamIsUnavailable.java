@Test public void shouldBuildDefaultConfigurationWhenConfigStreamIsUnavailable(){
  Mockito.when(mockServletContext.getResourceAsStream(Mockito.anyString())).thenThrow(new RuntimeException("BOOM!"));
  victim=new ServletContextPropertyWroConfigurationFactory(mockServletContext);
  Assert.assertNotNull(victim.create());
}
