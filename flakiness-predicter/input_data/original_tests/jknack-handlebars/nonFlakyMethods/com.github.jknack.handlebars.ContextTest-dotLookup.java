@Test public void dotLookup(){
  Context context=Context.newContext("String");
  assertNotNull(context);
  assertEquals("String",context.get("."));
}
