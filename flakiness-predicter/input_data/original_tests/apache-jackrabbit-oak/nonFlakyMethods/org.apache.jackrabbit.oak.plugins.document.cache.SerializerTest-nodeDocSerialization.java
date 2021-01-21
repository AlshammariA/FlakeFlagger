@Test public void nodeDocSerialization(){
  long time=System.currentTimeMillis();
  NodeDocument doc=new NodeDocument(store,time);
  doc.seal();
  checkSame(doc,(NodeDocument)deserialize(doc));
  doc=new NodeDocument(store,time);
  doc.put("_id","b1");
  doc.put("a2","b2");
  doc.seal();
  checkSame(doc,(NodeDocument)deserialize(doc));
  doc=new NodeDocument(store,time);
  doc.put("_id","b1");
  doc.put("a2",createRevisionMap());
  doc.put("a3",createRevisionMap());
  doc.seal();
  NodeDocument deserDoc=(NodeDocument)deserialize(doc);
  checkSame(doc,deserDoc);
  NavigableMap<Revision,Object> values=(NavigableMap<Revision,Object>)deserDoc.get("a2");
  assertTrue(Ordering.from(StableRevisionComparator.REVERSE).isOrdered(values.keySet()));
}
