@Test public void testCompactionMap(){
  int maxSegments=1000;
  int maxEntriesPerSegment=10;
  int seed=new Random().nextInt();
  SegmentTracker factory=new MemoryStore().getTracker();
  Map<RecordId,RecordId> map=new HashMap<RecordId,RecordId>();
  Random r=new Random(seed);
  int segments=r.nextInt(maxSegments);
  for (int i=0; i < segments; i++) {
    SegmentId id=factory.newDataSegmentId();
    int entries=r.nextInt(maxEntriesPerSegment);
    for (int j=0; j < entries; j++) {
      map.put(new RecordId(id,newValidOffset(r)),new RecordId(factory.newDataSegmentId(),newValidOffset(r)));
    }
  }
  CompactionMap compaction=new CompactionMap(map);
  for (  Entry<RecordId,RecordId> e : map.entrySet()) {
    assertTrue("Failed with seed " + seed,compaction.wasCompactedTo(e.getKey(),e.getValue()));
    assertFalse("Failed with seed " + seed,compaction.wasCompactedTo(e.getValue(),e.getKey()));
  }
}
