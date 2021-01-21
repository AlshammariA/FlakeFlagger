@Test public void testMergeSortedFilesDistinct() throws Exception {
  String line;
  List<String> result;
  BufferedReader bf;
  Comparator<String> cmp=new Comparator<String>(){
    @Override public int compare(    String o1,    String o2){
      return o1.compareTo(o2);
    }
  }
;
  File out=File.createTempFile("test_results",".tmp",null);
  ExternalSort.mergeSortedFiles(this.fileList,out,cmp,Charset.defaultCharset(),true);
  bf=new BufferedReader(new FileReader(out));
  result=new ArrayList<String>();
  while ((line=bf.readLine()) != null) {
    result.add(line);
  }
  bf.close();
  assertArrayEquals(Arrays.toString(result.toArray()),EXPECTED_MERGE_DISTINCT_RESULTS,result.toArray());
}
