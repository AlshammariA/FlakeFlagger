/** 
 * Test that on a major compaction, if all cells are expired or deleted, then we'll end up with no product.  Make sure scanner over region returns right answer in this case - and that it just basically works.
 * @throws IOException
 */
public void testMajorCompactingToNoOutput() throws IOException {
  createStoreFile(r);
  for (int i=0; i < COMPACTION_THRESHOLD; i++) {
    createStoreFile(r);
  }
  InternalScanner s=r.getScanner(new Scan());
  do {
    List<KeyValue> results=new ArrayList<KeyValue>();
    boolean result=s.next(results);
    r.delete(new Delete(results.get(0).getRow()),null,false);
    if (!result)     break;
  }
 while (true);
  r.flushcache();
  r.compactStores(true);
  s=r.getScanner(new Scan());
  int counter=0;
  do {
    List<KeyValue> results=new ArrayList<KeyValue>();
    boolean result=s.next(results);
    if (!result)     break;
    counter++;
  }
 while (true);
  assertEquals(0,counter);
}
