@Test public void testListWithLotsOfReferences(){
  SegmentTracker factory=store.getTracker();
  List<RecordId> list=newArrayList();
  for (int i=0; i < 1000; i++) {
    list.add(new RecordId(factory.newBulkSegmentId(),0));
  }
  writer.writeList(list);
}
