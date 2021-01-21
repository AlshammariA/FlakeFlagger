@Test public void testPropertyChanges(){
  JsopDiff diff;
  PropertyState before=StringPropertyState.stringProperty("foo","bar");
  diff=new JsopDiff();
  diff.propertyAdded(before);
  assertEquals("^\"/foo\":\"bar\"",diff.toString());
  diff=new JsopDiff();
  diff.propertyChanged(before,LongPropertyState.createLongProperty("foo",123L));
  assertEquals("^\"/foo\":123",diff.toString());
  diff=new JsopDiff();
  diff.propertyChanged(before,DoublePropertyState.doubleProperty("foo",1.23));
  assertEquals("^\"/foo\":1.23",diff.toString());
  diff=new JsopDiff();
  diff.propertyChanged(before,BooleanPropertyState.booleanProperty("foo",true));
  assertEquals("^\"/foo\":true",diff.toString());
  diff=new JsopDiff();
  diff.propertyDeleted(before);
  assertEquals("^\"/foo\":null",diff.toString());
}
