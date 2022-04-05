# Minimum number of deletions and insertions.
## Easy 
<div class="problem-statement">
                <p><a onclick="gtagHelperFunction('clickopen','salesevent_gsc_problemspage_promobanner')" href="https://practice.geeksforgeeks.org/summer-carnival-2022?utm_source=practiceproblems&amp;utm_medium=problemspromobanner&amp;utm_campaign=gsc22" target="_blank"></a></p><div style="margin: 14px 0px !important;" class="row"><a onclick="gtagHelperFunction('clickopen','salesevent_gsc_problemspage_promobanner')" href="https://practice.geeksforgeeks.org/summer-carnival-2022?utm_source=practiceproblems&amp;utm_medium=problemspromobanner&amp;utm_campaign=gsc22" target="_blank">             <div class="col-md-12" style="cursor:pointer;background: #EFF8F3 0% 0% no-repeat padding-box; display: flex; align-items: center; position:                 relative; padding: 1.5%; border-radius: 10px; display: inline-block; text-align: center; font-weight: 600; color: #333"> <img src="https://media.geeksforgeeks.org/img-practice/gcs2022thumbnail-1649059370.png" alt="Lamp" width="46" height="40" style="background: transparent 0% 0% no-repeat padding-box;opacity: 1; margin: 0 16px;" class="img-responsive"> Geeks Summer Carnival is LIVE NOW &nbsp; <i class="fa fa-external-link" aria-hidden="true"></i> </div></a></div><p><span style="font-size:18px">Given two strings <strong>str1</strong> and <strong>str2</strong>. The task is to remove or insert the minimum number of characters from/in <strong>str1</strong> so as to transform it into <strong>str2</strong>. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>str1 = "heap", str2 = "pea"
<strong>Output:</strong> 3
<strong>Explanation: </strong>2 deletions and 1 insertion</span>
<strong><span style="font-size:18px">p</span></strong><span style="font-size:18px"> and <strong>h</strong> deleted from <strong>heap</strong>. Then, <strong>p</strong> is 
inserted at the beginning One thing to 
note, though <strong>p</strong> was required yet it was 
removed/deleted first from its position 
and then it is inserted to some other 
position. Thus, <strong>p</strong> contributes one to the 
<strong>deletion_count</strong> and one to the 
<strong>insertion_count</strong>.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>str1 = "geeksforgeeks"
str2 = "geeks"
<strong>Output: </strong>8
<strong>Explanation: </strong>8 deletions</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or&nbsp;print anything. Your task is to complete the function <strong>minOperations()&nbsp;</strong>which takes both strings as input parameter and returns the minimum number of operation required.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|str1|*|str2|)<br>
<strong>Expected Space Complexity: </strong>O(|str1|*|str2|</span><span style="font-size:18px">)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ |str1|, |str2| ≤ 1000</span><br>
<span style="font-size:18px">All the characters are lower case English alphabets</span></p>
 <p></p>
            </div>