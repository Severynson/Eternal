import json
import random
from datetime import datetime, timedelta
import os

level_titles = [
    "Level 3, Fragmentation.",
    "Level 5, Reveal the truth.",
    "Level 1, Library",
]


def random_date():
    random_days = random.randint(0, 365)
    random_datetime = datetime.utcnow() + timedelta(days=random_days)
    return random_datetime.strftime(
        "%Y-%m-%dT%H:%M:%SZ"
    )  # ISO 8601 format is important, don't change without reason.


current_folder = os.getcwd()

for index in range(1, 4):
    file_data = {
        "fileTitle": f"dummy_save_{index}",
        "levelTitle": level_titles[index - 1],
        "lastModified": random_date(),
    }

    file_name = f"dummy_save_{index}.json"
    file_path = os.path.join(current_folder, "saves", file_name)

    with open(file_path, "w") as json_file:
        json.dump(file_data, json_file, indent=2)

print(f"JSON files generated successfully.")
