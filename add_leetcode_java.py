import os
import subprocess

# === Inputs ===
problem_title = input("Enter problem title (e.g., Two Sum): ")
file_name = problem_title.replace(" ", "") + ".java"
topic = input("Enter topic (e.g., arrays, strings, dp): ")
url = input("Enter LeetCode URL: ")

print("Paste your Java solution below (end input with `END` on a new line):")
code_lines = []
while True:
    line = input()
    if line.strip() == "END":
        break
    code_lines.append(line)
code = "\n".join(code_lines)

# === Save File ===
folder_path = f"src/{topic.lower()}"
os.makedirs(folder_path, exist_ok=True)
file_path = os.path.join(folder_path, file_name)

with open(file_path, "w") as f:
    f.write(f"// Problem: {url}\n")
    f.write(code)

# === Update README.md ===
readme_path = "README.md"
if not os.path.exists(readme_path):
    with open(readme_path, "w") as f:
        f.write("# 💻 LeetCode DSA Java Solutions\n\n| # | Problem | Link | Topic | Code |\n|--|---------|------|--------|------|\n")

# Count current problems
with open(readme_path, "r") as f:
    lines = f.readlines()
    count = 0
    for line in lines:
        parts = line.strip().split("|")
        if len(parts) >= 5 and parts[1].strip().isdigit():
            count = max(count, int(parts[1].strip()))

with open(readme_path, "a") as f:
    f.write(f"| {count + 1} | {problem_title} | [Link]({url}) | {topic.capitalize()} | [{file_name}]({file_path}) |\n")

# === Git Add/Commit/Push ===
subprocess.run(["git", "add", "."])
subprocess.run(["git", "commit", "-m", f"Added {problem_title}"])
subprocess.run(["git", "push"])
