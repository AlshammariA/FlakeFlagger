@Test public void serializerFactory() throws Exception {
  DataSource dataSource=new DataSource();
  SerializerFactory factory=BeanSerializerFactory.instance.withSerializerModifier(new GenericSerializerModifier());
  ObjectMapper mapper=new ObjectMapper();
  mapper.setSerializerFactory(factory);
  String value=mapper.writeValueAsString(dataSource);
  assertTrue(value.contains("\"url\":"));
}
