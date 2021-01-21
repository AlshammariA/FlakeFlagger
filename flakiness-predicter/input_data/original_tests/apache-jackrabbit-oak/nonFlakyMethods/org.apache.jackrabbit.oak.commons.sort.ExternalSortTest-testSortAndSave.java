@Test public void testSortAndSave() throws Exception {
  File f;
  String line;
  List<String> result;
  BufferedReader bf;
  List<String> sample=Arrays.asList(SAMPLE);
  Comparator<String> cmp=new Comparator<String>(){
    @Override public int compare(    String o1,    String o2){
      return o1.compareTo(o2);
    }
  }
;
  f=ExternalSort.sortAndSave(sample,cmp,Charset.defaultCharset(),null,false,false);
  assertNotNull(f);
  assertTrue(f.exists());
  assertTrue(f.length() > 0);
  bf=new BufferedReader(new FileReader(f));
  result=new ArrayList<String>();
  while ((line=bf.readLine()) != null) {
    result.add(line);
  }
  bf.close();
  assertArrayEquals(Arrays.toString(result.toArray()),EXPECTED_SORT_RESULTS,result.toArray());
}
