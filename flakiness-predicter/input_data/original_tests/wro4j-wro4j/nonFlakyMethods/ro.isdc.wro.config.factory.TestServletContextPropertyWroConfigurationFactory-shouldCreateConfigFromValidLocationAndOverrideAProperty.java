@Test public void shouldCreateConfigFromValidLocationAndOverrideAProperty() throws Exception {
  final long connectionTimeout=10000;
  final Properties props=new Properties();
  props.setProperty(ConfigConstants.connectionTimeout.name(),String.valueOf(connectionTimeout));
  final StringWriter propertiesWriter=new StringWriter();
  props.store(new WriterOutputStream(propertiesWriter),"");
  Mockito.when(mockServletContext.getResourceAsStream(Mockito.anyString())).thenReturn(new ByteArrayInputStream(propertiesWriter.toString().getBytes()));
  Assert.assertEquals(connectionTimeout,victim.create().getConnectionTimeout());
}
