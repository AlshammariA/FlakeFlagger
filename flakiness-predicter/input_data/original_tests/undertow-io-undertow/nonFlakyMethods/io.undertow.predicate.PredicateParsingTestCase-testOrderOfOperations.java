@Test public void testOrderOfOperations(){
  expect("exists[%{i,Content-Length}] or exists[value=%{i,Trailer}] and exists[%{i,Other}]",false,true);
  expect("(exists[%{i,Content-Length}] or exists[value=%{i,Trailer}]) and exists[%{i,Other}]",false,false);
}
