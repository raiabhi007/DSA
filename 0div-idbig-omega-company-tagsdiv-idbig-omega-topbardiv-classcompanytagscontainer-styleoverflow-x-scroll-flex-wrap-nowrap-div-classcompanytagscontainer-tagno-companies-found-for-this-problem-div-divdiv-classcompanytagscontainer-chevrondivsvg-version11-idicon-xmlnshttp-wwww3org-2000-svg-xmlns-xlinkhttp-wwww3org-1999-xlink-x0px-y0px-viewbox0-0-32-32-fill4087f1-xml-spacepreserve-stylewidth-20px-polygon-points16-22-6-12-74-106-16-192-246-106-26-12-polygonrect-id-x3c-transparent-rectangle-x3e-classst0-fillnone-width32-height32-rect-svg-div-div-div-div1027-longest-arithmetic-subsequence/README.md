<h2><a href="https://leetcode.com/problems/longest-arithmetic-subsequence/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1027. Longest Arithmetic Subsequence</a></h2><h3>Medium</h3><hr><div><p>Given an array <code>nums</code> of integers, return <em>the length of the longest arithmetic subsequence in</em> <code>nums</code>.</p>

<p><strong>Note</strong> that:</p>

<ul>
	<li>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</li>
	<li>A sequence <code>seq</code> is arithmetic if <code>seq[i + 1] - seq[i]</code> are all the same value (for <code>0 &lt;= i &lt; seq.length - 1</code>).</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,6,9,12]
<strong>Output:</strong> 4
<strong>Explanation: </strong> The whole array is an arithmetic sequence with steps of length = 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [9,4,7,2,10]
<strong>Output:</strong> 3
<strong>Explanation: </strong> The longest arithmetic subsequence is [4,7,10].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [20,1,15,3,10,5,8]
<strong>Output:</strong> 4
<strong>Explanation: </strong> The longest arithmetic subsequence is [20,15,10,5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 500</code></li>
</ul>
</div>