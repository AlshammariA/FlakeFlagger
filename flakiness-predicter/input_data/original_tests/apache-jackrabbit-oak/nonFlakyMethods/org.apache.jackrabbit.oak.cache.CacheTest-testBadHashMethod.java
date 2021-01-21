@Test public void testBadHashMethod(){
  final int size=4;
  /** 
 * A class with a bad hashCode implementation.
 */
class BadHash {
    int x;
    BadHash(    int x){
      this.x=x;
    }
    @Override public int hashCode(){
      return (x & 1) * size * 2;
    }
    @Override public boolean equals(    Object o){
      return ((BadHash)o).x == x;
    }
    @Override public String toString(){
      return "" + x;
    }
  }
  CacheLIRS<BadHash,Integer> test=createCache(size * 2);
  for (int i=0; i < size; i++) {
    test.put(new BadHash(i),i);
  }
  for (int i=0; i < size; i++) {
    if (i % 3 == 0) {
      assertEquals(i,test.remove(new BadHash(i)).intValue());
      assertNull(test.remove(new BadHash(i)));
    }
  }
  for (int i=0; i < size; i++) {
    if (i % 3 == 0) {
      assertNull(test.getIfPresent(new BadHash(i)));
    }
 else {
      assertEquals(i,test.getIfPresent(new BadHash(i)).intValue());
    }
  }
  for (int i=0; i < size; i++) {
    test.put(new BadHash(i),i);
  }
  for (int i=0; i < size; i++) {
    if (i % 3 == 0) {
      assertEquals(i,test.remove(new BadHash(i)).intValue());
      assertNull(test.remove(new BadHash(i)));
    }
  }
  for (int i=0; i < size; i++) {
    if (i % 3 == 0) {
      assertNull(test.getIfPresent(new BadHash(i)));
    }
 else {
      assertEquals(i,test.getIfPresent(new BadHash(i)).intValue());
    }
  }
}
