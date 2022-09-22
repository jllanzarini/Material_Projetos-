bx = 0
by = 0
vx = 10
vy = 0
mx = 0
my = 0
bdx = 0
score = 0

const update_score = () => $('.score').text(`Score: ${score}`)
$(document).ready(() => {
  ball = $('.ball')
  board = $('.board')
  const render = () => {
    check_board = false
    bdx = mx - 50
    vy += 0.5
    _tbx = bx + vx
    _tby = by + vy
    if (_tbx < 0) vx = Math.abs(vx)
    else if (_tbx + 20 > $(window).width()) vx = -Math.abs(vx)
    if (_tby < 0) vy = Math.abs(vy)
    else if (_tby + 20 > $(window).height()) {
      vy = -Math.abs(vy)
      check_board = true
    }
    bx += vx
    by += vy
    if (check_board) {
      if (bdx <= bx && bx <= bdx + 100) {
        score++
        update_score()
      }
    }
    ball.css('top', `${by}px`)
    ball.css('left', `${bx}px`)
    board.css('left', `${bdx}px`)
    window.requestAnimationFrame(render)
  }
  update_score()
  window.requestAnimationFrame(render)
  $(document).on('mousemove', event => {
    [mx, my] = [event.pageX, event.pageY]
  })
})
