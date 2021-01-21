public void testRawValue(){
  JsopStream s=new JsopStream().tag('+').key("x").object().key("y").array().value(1).array().endArray().value(2).endArray().endObject();
  assertEquals("+\"x\":{\"y\":[1,[],2]}",s.toString());
  testRawValue(s);
  testRawValue(new JsopTokenizer(s.toString()));
}
