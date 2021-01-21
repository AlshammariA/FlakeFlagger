@Test public void testRandomized() throws Exception {
  Random r=new Random(0);
  for (int i=0; i < 10000; i++) {
    TreeSet<String> marked=new TreeSet<String>();
    TreeSet<String> all=new TreeSet<String>();
    TreeSet<String> diff=new TreeSet<String>();
    int size=r.nextInt(5);
    for (int a=0; a < size; a++) {
      marked.add("" + r.nextInt(10));
    }
    size=r.nextInt(5);
    for (int a=0; a < size; a++) {
      all.add("" + r.nextInt(10));
    }
    diff.addAll(all);
    diff.removeAll(marked);
    String m=marked.toString().replaceAll("[ \\[\\]]","");
    String a=all.toString().replaceAll("[ \\[\\]]","");
    assertDiff(m,a,new ArrayList<String>(diff));
  }
}
