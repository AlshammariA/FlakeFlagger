@Test public void customLookup(){
  Context context=Context.newContext(new Base());
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
  assertEquals("baseProperty",context.get("childProperty"));
}
