class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
         HashMap<String, List<String>> fileMap = new HashMap();
        
        for(String path : paths){
            String[] files = path.split(" ");
            String directory = files[0];
            
            //add all file path in same content
            for(String file : files){
                int index = file.indexOf("(");
                if(index == -1) continue;
                
                String fileName = file.substring(0, index);
                String fileContent = file.substring(index + 1, file.length() - 1);
                
                fileMap.putIfAbsent(fileContent, new ArrayList<String>());
                fileMap.get(fileContent).add(directory + "/" + fileName);
                    }
        }        
        //get all files, with duplicate content
        List<List<String>> results = new ArrayList();
        for(List<String> files : fileMap.values()){
            //must have two file, with same content
            if(files.size() > 1) results.add(files);
        }
        
        return results;
    }
}