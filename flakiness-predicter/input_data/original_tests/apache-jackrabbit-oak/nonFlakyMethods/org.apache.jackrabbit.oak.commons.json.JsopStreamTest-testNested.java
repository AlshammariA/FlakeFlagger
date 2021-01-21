public void testNested(){
  JsopStream s=new JsopStream().key("x");
  JsopStream nested=new JsopStream().array().value(1).value(null).value(true).value(false).value("Hello").endArray();
  s.append(nested);
  assertEquals("\"x\":[1,null,true,false,\"Hello\"]",s.toString());
}
