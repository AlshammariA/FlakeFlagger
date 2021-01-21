@Test public void singleObjectLookup(){
  Object model=new Object(){
    @SuppressWarnings("unused") public String getSimple(){
      return "value";
    }
    @Override public String toString(){
      return "Model Object";
    }
  }
;
  Context context=Context.newContext(model);
  assertNotNull(context);
  assertEquals("value",context.get("simple"));
}
