@Test public void thisLookup(){
  Context context=Context.newContext("String");
  assertNotNull(context);
  assertEquals("String",context.get("this"));
}
