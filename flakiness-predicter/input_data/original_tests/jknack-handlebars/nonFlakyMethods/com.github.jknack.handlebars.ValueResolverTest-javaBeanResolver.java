@Test public void javaBeanResolver(){
  Context context=Context.newBuilder(new Base("a","b")).resolver(JavaBeanValueResolver.INSTANCE).build();
  assertNotNull(context);
  assertEquals("a",context.get("baseProperty"));
  assertEquals("b",context.get("childProperty"));
}
