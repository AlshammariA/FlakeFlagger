@Test public void customLookupOnChildClass(){
  Context context=Context.newContext(new Child());
  assertNotNull(context);
  assertEquals("baseProperty",context.get("baseProperty"));
  assertEquals("childProperty",context.get("childProperty"));
}
