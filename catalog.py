def gen(file):
    links = []
    with open(file, 'r', encoding='utf8') as f:
        line = f.readline()
        while line:
            if line.startswith('###'):
                title = line.split('###')[1].strip()
                link = '> [' + title + '](#' + title + ')'
                links.append(link)
            line = f.readline()

    for link in links:
        print(link)


if __name__ == '__main__':
    gen('LeetcodeNote.md')
