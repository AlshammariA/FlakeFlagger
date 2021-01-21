public static void testBuilder(){
  JsopWriter buff=new JsopStream();
  buff.tag('+').object().key("foo").value("bar").key("int").value(3).key("decimal").encodedValue("3.0").key("obj").object().key("boolean").value(true).key("null").value(null).key("arr").array().array().value(1).value("\u001f ~ \u007f \u0080").value("42").endArray().array().endArray().endArray().endObject().key("some").value("more").endObject();
  String json=buff.toString();
  assertEquals("+{\"foo\":\"bar\",\"int\":3,\"decimal\":3.0," + "\"obj\":{\"boolean\":true,\"null\":null," + "\"arr\":[[1,\"\\u001f ~ \\u007f \\u0080\",\"42\"],[]]},\"some\":\"more\"}",json);
  buff.resetWriter();
  buff.array().object().key("x").value("1").endObject().newline().object().key("y").value("2").endObject().newline().endArray();
  json=buff.toString();
  assertEquals("[{\"x\":\"1\"}\n,{\"y\":\"2\"}\n]",json);
  buff=new JsopStream();
  buff.tag('+').key("x").value("1").newline();
  buff.tag('+').key("y").value("2").newline();
  buff.tag('+').key("z").value(false).newline();
  json=buff.toString();
  assertEquals("+\"x\":\"1\"\n+\"y\":\"2\"\n+\"z\":false\n",json);
}
