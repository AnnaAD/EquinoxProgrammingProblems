#! /bin/csh -f

set max = $argv[1]

@ i = 0
while ($i <= $max) 
    if ($i < 10) then
	set num = "0$i"
    else
	set num = $i
    endif

    echo input/input${num}.txt output/output${num}.txt
    java -cp ../../ProgrammingProblems/bin/ $argv[2] < input/input${num}.txt > output/output${num}.txt
    @ i ++
end


