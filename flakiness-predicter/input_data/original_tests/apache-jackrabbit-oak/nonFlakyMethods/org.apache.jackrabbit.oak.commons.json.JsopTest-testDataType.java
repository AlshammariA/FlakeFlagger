public void testDataType(){
  String dateString=new JsopBuilder().key("string").value("/Date(0)/").key("date").encodedValue("\"\\/Date(0)\\/\"").toString();
  assertEquals("\"string\":\"/Date(0)/\"," + "\"date\":\"\\/Date(0)\\/\"",dateString);
  JsopTokenizer t=new JsopTokenizer(dateString);
  assertEquals("string",t.readString());
  t.read(':');
  assertEquals("/Date(0)/",t.readString());
  assertEquals("/Date(0)/",t.getEscapedToken());
  t.read(',');
  assertEquals("date",t.readString());
  t.read(':');
  assertEquals("/Date(0)/",t.readString());
  assertEquals("\\/Date(0)\\/",t.getEscapedToken());
}
