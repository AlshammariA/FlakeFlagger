@Test public void nodeAndPropertyNames(){
  DocumentMK mk=createMK();
  String rev;
  String nodes;
  for (  String s : new String[]{"_","$","__","_id","$x",".",".\\","x\\","\\x","first.name"}) {
    String x2=Utils.escapePropertyName(s);
    String s2=Utils.unescapePropertyName(x2);
    if (!s.equals(s2)) {
      assertEquals(s,s2);
    }
    JsopBuilder jsop=new JsopBuilder();
    jsop.tag('+').key(s).object().key(s).value("x").endObject();
    rev=mk.commit("/",jsop.toString(),null,null);
    nodes=mk.getNodes("/" + s,rev,0,0,10,null);
    jsop=new JsopBuilder();
    jsop.object().key(s).value("x").key(":childNodeCount").value(0).endObject();
    String n=jsop.toString();
    assertEquals(n,nodes);
    nodes=mk.getNodes("/",rev,0,0,10,null);
    jsop=new JsopBuilder();
    jsop.object().key(s).object().endObject().key(":childNodeCount").value(1).endObject();
    n=jsop.toString();
    assertEquals(n,nodes);
    jsop=new JsopBuilder();
    jsop.tag('-').value(s);
    rev=mk.commit("/",jsop.toString(),rev,null);
  }
}
