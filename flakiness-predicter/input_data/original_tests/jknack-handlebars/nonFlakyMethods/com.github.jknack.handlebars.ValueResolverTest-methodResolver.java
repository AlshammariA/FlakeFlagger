@Test public void methodResolver(){
  Context context=Context.newBuilder(new Base("a","b")).resolver(MethodValueResolver.INSTANCE).build();
  assertNotNull(context);
  assertEquals("a",context.get("getBaseProperty"));
  assertEquals("b",context.get("getChildProperty"));
}
