@Test public void test(){
  for (  int size : seq(0,100)) {
    for (    int readBefore : seq(0,30)) {
      long timeout=size % 3 == 0 ? 100 : 0;
      Iterable<Integer> s=seq(0,size);
      PrefetchIterator<Integer> it=new PrefetchIterator<Integer>(s.iterator(),20,timeout,30,-1);
      for (      int x : seq(0,readBefore)) {
        boolean hasNext=it.hasNext();
        if (!hasNext) {
          assertEquals(x,size);
          break;
        }
        String m="s:" + size + " b:"+ readBefore+ " x:"+ x;
        assertTrue(m,hasNext);
        assertEquals(m,x,it.next().intValue());
      }
      String m="s:" + size + " b:"+ readBefore;
      int max=timeout <= 0 ? 20 : 30;
      if (size > max && readBefore <= size) {
        assertEquals(m,-1,it.size());
        assertEquals(m,-1,it.size());
      }
 else {
        assertEquals(m,size,it.size());
        assertEquals(m,size,it.size());
      }
      for (      int x : seq(readBefore,size)) {
        m="s:" + size + " b:"+ readBefore+ " x:"+ x;
        assertTrue(m,it.hasNext());
        assertEquals(m,x,it.next().intValue());
      }
      assertFalse(it.hasNext());
      try {
        it.next();
        fail();
      }
 catch (      NoSuchElementException e) {
      }
      try {
        it.remove();
        fail();
      }
 catch (      UnsupportedOperationException e) {
      }
    }
  }
}
