@Test public void absent(){
  registry.add(House.class,"a",Window.class);
  Class<?> result=registry.findDefaultComponentType(House.class,"other");
  assertNull(result);
}
