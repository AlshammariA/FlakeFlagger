@Test public void smoke(){
  String propertyName="window";
  registry.add(House.class,propertyName,Window.class);
  Class<?> result=registry.findDefaultComponentType(House.class,propertyName);
  assertEquals(Window.class,result);
}
