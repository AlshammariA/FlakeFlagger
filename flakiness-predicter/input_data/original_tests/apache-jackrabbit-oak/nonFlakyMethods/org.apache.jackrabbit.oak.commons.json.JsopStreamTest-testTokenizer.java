public void testTokenizer(){
  test("+ \"x\": {}",new JsopStream().tag('+').key("x").object().endObject());
  test("[\"-1\": -1, " + "\"true\": true, " + "\"false\": false, "+ "\"null\": null]",new JsopStream().array().key("-1").value(-1).key("true").value(true).key("false").value(false).key("null").value(null).endArray());
}
