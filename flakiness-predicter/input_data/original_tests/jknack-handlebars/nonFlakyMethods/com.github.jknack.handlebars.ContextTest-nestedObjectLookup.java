@Test public void nestedObjectLookup(){
  Object model=new Object(){
    @SuppressWarnings("unused") public Object getNested(){
      return new Object(){
        public String getSimple(){
          return "value";
        }
      }
;
    }
  }
;
  Context context=Context.newContext(model);
  assertNotNull(context);
  assertEquals("value",context.get("nested.simple"));
}
